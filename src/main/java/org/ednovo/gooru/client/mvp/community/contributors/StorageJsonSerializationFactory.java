package org.ednovo.gooru.client.mvp.community.contributors;

import java.util.ArrayList;

import org.ednovo.gooru.shared.model.library.LibraryUserDo;

import com.googlecode.gwt.serialization.JsonSerializationFactory;

public interface StorageJsonSerializationFactory extends JsonSerializationFactory<ArrayList<LibraryUserDo>> {
}