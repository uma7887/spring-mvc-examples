package com.formbuilder.sqlemit;

import lombok.val;

public class Util {
	private static final String appTable = "CREATE TABLE ui_app (ui_app_id integer Not null, name Varchar(50), display_name Varchar(50));";
	private static final String appTableInsert = "insert into ui_app values (1, '%s', '%s');";
	private static final String uiFormTable = "CREATE TABLE ui_form( id integer Not Null, form_table_name Varchar(100), order_by integer, display_name Varchar(100), name_column_display_name Varchar(50), group_by Varchar(30), ui_app_id integer);";
	private static final String uiFormLinkTable = "CREATE TABLE ui_form_link( ui_form_id integer Not Null, ui_form_link_id integer, link_name Varchar(50), single_select boolean);";
	private static final String uiRuleTable = "CREATE TABLE ui_rule ( ui_form_id integer Not null, clause Varchar(500));";

	static String createGenericTables(String appName) {
		StringBuffer sb = new StringBuffer(appTable + System.lineSeparator() + uiFormTable + System.lineSeparator() + uiFormLinkTable
				+ System.lineSeparator() + uiRuleTable + System.lineSeparator());

		sb.append(String.format(appTableInsert, appName, getDisplayName(appName).trim()) + System.lineSeparator());

		return sb.toString();
	}

	public static String getDisplayName(String name) {
		// TODO Auto-generated method stub
		val split = name.split("_");
		val res = new StringBuffer();

		for (String str : split) {
			char[] stringArray = str.trim().toCharArray();
			if (stringArray.length > 0) {
				stringArray[0] = Character.toUpperCase(stringArray[0]);
				str = new String(stringArray);
			}
			res.append(str).append(" ");
		}

		return res.toString();
	}

}
