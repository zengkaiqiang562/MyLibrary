package com.zengk.library.datastore.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MySqliteOpenHelper extends SQLiteOpenHelper {

	public MySqliteOpenHelper(Context context) {

		//context: 应用上下文 对象

		// name: 数据库的名称
		//游标 工厂  :  Cursor---cursorFactory
		// version: 版本, 数据库的版本

		//初始版本 必须是 大于 零的, 并且 数据库的版本只能 够升级, 不能够 降级
		super(context, "zengk.db", null, 3);
	}

	// 就是 数据库 文件第一次 创建的时候 会执行的方法
	@Override
	public void onCreate(SQLiteDatabase db) {

		System.out.println("onCreate ... 被调用了  ...");

		//在这里去 在数据库 中创建 表
		db.execSQL("create table users( _id integer primary key autoincrement, username varchar(30), password varchar(40) )");

	}

	/**
	 数据库初次创建的时候 会执行 onCreate 方法
	 系统回去 检查当前是否已经有 zengk.db数据库了. 并且回去检查初始版本是 几 . 一旦初始版本确定下来, 那么
	 后续的 版本就必须要比 初始版本要高.否则会报错.
	 并且 一旦发现 后续的版本比现有的版本要高, 那么就会去执行onUpgrade

	 这个方法 主要用来完成  数据库的 升级
	 例如: 应用程序已经 发布到安卓 市场上了, 隔一段 时间 会有 新版本,  数据库的结构 也更改了,. 那么这个时候
	 要对数据库也进行 升级了,  这个时候只需要去 给一个新的版本进来.  并且 在onupgrade 方法去修改表的结构就可以了.
	 * @param db
	 * @param oldVersion
	 * @param newVersion
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		System.out.println("onUpgrade ... 被调用了  ...");

		db.execSQL("alter table users add city varchar(40)");
	}

}
