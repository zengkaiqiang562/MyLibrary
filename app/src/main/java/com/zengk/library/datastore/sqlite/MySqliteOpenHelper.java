package com.zengk.library.datastore.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MySqliteOpenHelper extends SQLiteOpenHelper {

	public MySqliteOpenHelper(Context context) {

		//context: Ӧ�������� ����

		// name: ���ݿ������
		//�α� ����  :  Cursor---cursorFactory
		// version: �汾, ���ݿ�İ汾

		//��ʼ�汾 ������ ���� ���, ���� ���ݿ�İ汾ֻ�� ������, ���ܹ� ����
		super(context, "zengk.db", null, 3);
	}

	// ���� ���ݿ� �ļ���һ�� ������ʱ�� ��ִ�еķ���
	@Override
	public void onCreate(SQLiteDatabase db) {

		System.out.println("onCreate ... ��������  ...");

		//������ȥ �����ݿ� �д��� ��
		db.execSQL("create table users( _id integer primary key autoincrement, username varchar(30), password varchar(40) )");

	}

	/**
	 ���ݿ���δ�����ʱ�� ��ִ�� onCreate ����
	 ϵͳ��ȥ ��鵱ǰ�Ƿ��Ѿ��� zengk.db���ݿ���. ���һ�ȥ����ʼ�汾�� �� . һ����ʼ�汾ȷ������, ��ô
	 ������ �汾�ͱ���Ҫ�� ��ʼ�汾Ҫ��.����ᱨ��.
	 ���� һ������ �����İ汾�����еİ汾Ҫ��, ��ô�ͻ�ȥִ��onUpgrade

	 ������� ��Ҫ�������  ���ݿ�� ����
	 ����: Ӧ�ó����Ѿ� ��������׿ �г�����, ��һ�� ʱ�� ���� �°汾,  ���ݿ�Ľṹ Ҳ������,. ��ô���ʱ��
	 Ҫ�����ݿ�Ҳ���� ������,  ���ʱ��ֻ��Ҫȥ ��һ���µİ汾����.  ���� ��onupgrade ����ȥ�޸ı�Ľṹ�Ϳ�����.
	 * @param db
	 * @param oldVersion
	 * @param newVersion
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		System.out.println("onUpgrade ... ��������  ...");

		db.execSQL("alter table users add city varchar(40)");
	}

}
