package org.ednovo.gooru.application.shared.model.code;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class MessageDo implements Serializable
{
	private static final long serialVersionUID = 1L;

	public MessageDo(){

		}
}
