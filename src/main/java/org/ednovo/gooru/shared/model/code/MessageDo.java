package org.ednovo.gooru.shared.model.code;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.model.content.PublishDo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class MessageDo implements Serializable
{
	private static final long serialVersionUID = 1L;

	public MessageDo(){
			
		}
}
