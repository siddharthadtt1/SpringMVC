package org.practice.customeditor;

import java.beans.PropertyEditorSupport;

public class StudentNamePropertyEditorSupport extends PropertyEditorSupport {

	@Override
	public void setAsText(String name) {
		System.out.println("Received name of student as : " + name);
		if (name.startsWith("Mr") || name.startsWith("Ms")) {
			setValue(name);
		} else {
			name = "Mr " + name;
			setValue(name);
		}
	}

}
