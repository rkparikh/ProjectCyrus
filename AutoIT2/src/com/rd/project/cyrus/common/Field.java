package com.rd.project.cyrus.common;

public class Field {
	private String fieldName;
	private String fieldId;
	private String fieldValue;
	private int indexInArr;

	public Field(String fieldName, String fieldId, String fieldValue,
			int indexInArr) {
		super();
		this.fieldName = fieldName;
		this.fieldId = fieldId;
		this.fieldValue = fieldValue;
		this.indexInArr = indexInArr;
	}

	public Field(String fieldName, String fieldId, String fieldValue) {
		this(fieldName, fieldId, fieldValue, -1);
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getFieldId() {
		return fieldId;
	}

	public void setFieldId(String fieldId) {
		this.fieldId = fieldId;
	}

	public String getFieldValue() {
		return fieldValue;
	}

	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}

	public int getIndexInArr() {
		return indexInArr;
	}

	public void setIndexInArr(int indexInArr) {
		this.indexInArr = indexInArr;
	}

	@Override
	public String toString() {
		return "Field [fieldName=" + fieldName + ", fieldValue=" + fieldValue
				+ "]";
	}

}
