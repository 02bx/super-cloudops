package com.wl4g.devops.coss.client.channel.netty.codec;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wl4g.devops.coss.client.channel.netty.MediaType;

/**
 * Implementation that can read and write JSON using
 * <a href="http://wiki.fasterxml.com/JacksonHome">Jackson 2.x's</a>
 * {@link ObjectMapper}.
 *
 * <p>
 * This converter can be used to bind to typed beans, or untyped {@code HashMap}
 * instances.
 *
 * <p>
 * By default, this converter supports {@code application/json} and
 * {@code application/*+json} with {@code UTF-8} character set. This can be
 * overridden by setting the {@link #setSupportedMediaTypes supportedMediaTypes}
 * property.
 *
 * <p>
 * The default constructor uses the default configuration provided by
 * {@link Jackson2ObjectMapperBuilder}.
 *
 * <p>
 */
public class MappingJackson2HttpMessageCodec extends AbstractJackson2HttpMessageCodec {

	private String jsonPrefix;

	/**
	 * Construct a new {@link MappingJackson2HttpMessageCodec} using default
	 * configuration provided by {@link Jackson2ObjectMapperBuilder}.
	 */
	public MappingJackson2HttpMessageCodec() {
		this(Jackson2ObjectMapperBuilder.json().build());
	}

	/**
	 * Construct a new {@link MappingJackson2HttpMessageCodec} with a custom
	 * {@link ObjectMapper}. You can use {@link Jackson2ObjectMapperBuilder} to
	 * build it easily.
	 * 
	 * @see Jackson2ObjectMapperBuilder#json()
	 */
	public MappingJackson2HttpMessageCodec(ObjectMapper objectMapper) {
		super(objectMapper, MediaType.APPLICATION_JSON, new MediaType("application", "*+json"));
	}

	/**
	 * Specify a custom prefix to use for this view's JSON output. Default is
	 * none.
	 * 
	 * @see #setPrefixJson
	 */
	public void setJsonPrefix(String jsonPrefix) {
		this.jsonPrefix = jsonPrefix;
	}

	/**
	 * Indicate whether the JSON output by this view should be prefixed with
	 * ")]}', ". Default is false.
	 * <p>
	 * Prefixing the JSON string in this manner is used to help prevent JSON
	 * Hijacking. The prefix renders the string syntactically invalid as a
	 * script so that it cannot be hijacked. This prefix should be stripped
	 * before parsing the string as JSON.
	 * 
	 * @see #setJsonPrefix
	 */
	public void setPrefixJson(boolean prefixJson) {
		this.jsonPrefix = (prefixJson ? ")]}', " : null);
	}

	@Override
	protected void writePrefix(JsonGenerator generator, Object object) throws IOException {
		if (this.jsonPrefix != null) {
			generator.writeRaw(this.jsonPrefix);
		}
		String jsonpFunction = (object instanceof MappingJacksonValue ? ((MappingJacksonValue) object).getJsonpFunction() : null);
		if (jsonpFunction != null) {
			generator.writeRaw("/**/");
			generator.writeRaw(jsonpFunction + "(");
		}
	}

	@Override
	protected void writeSuffix(JsonGenerator generator, Object object) throws IOException {
		String jsonpFunction = (object instanceof MappingJacksonValue ? ((MappingJacksonValue) object).getJsonpFunction() : null);
		if (jsonpFunction != null) {
			generator.writeRaw(");");
		}
	}

}
