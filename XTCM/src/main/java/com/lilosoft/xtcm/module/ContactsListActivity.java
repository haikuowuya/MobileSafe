package com.lilosoft.xtcm.module;

import java.util.List;
import java.util.Map;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;
import android.widget.ExpandableListView.OnChildClickListener;

import com.lilosoft.xtcm.R;
import com.lilosoft.xtcm.base.NormalBaseActivity;
import com.lilosoft.xtcm.base.TabBaseActivity;
import com.lilosoft.xtcm.dao.CommonNumberDao;
import com.lilosoft.xtcm.views.TitleBar;
import com.lilosoft.xtcm.views.TitleBar.STYLE;

public class ContactsListActivity extends NormalBaseActivity {

	private TitleBar mTitleBar;
	private ExpandableListView elv;

	@Override
	protected void installViews() {
		// TODO Auto-generated method stub
		setContentView(R.layout.activity_contactslist);
		initTitleBar();
		initValues();
	}

	private void initValues() {
		elv = (ExpandableListView) findViewById(R.id.elv);

//		if (!CommonNumberDao.isExist()) {
//			CommonNumberDao.copyDB(this);
//		}

		// ������
		List<Map<String, Object>> groupData = CommonNumberDao.getGroupData(mContext);
		// ������
		List<List<Map<String, Object>>> childData = CommonNumberDao
				.getChildData(mContext);

		final SimpleExpandableListAdapter adapter = new SimpleExpandableListAdapter(
				this,// ������
				groupData,// ������ List<Map<String,Object>>
				android.R.layout.simple_expandable_list_item_1,// �鲼�� R.layout.
				new String[] { "dept" }, // �����ݵ�key String[]
				new int[] { android.R.id.text1 }, // �鲼�ֿؼ���id int[]
				childData, // ���ӵ����� List<List<Map<String,Object>>>
				android.R.layout.simple_expandable_list_item_2,// ���ӵĲ��� R.layout
				new String[] { "name", "phone" }, // �������ݵ�key String[]
				new int[] { android.R.id.text1, android.R.id.text2 });// ���Ӳ��ֿؼ���id
																		// int[]
		elv.setAdapter(adapter);

		// ���ú�����Ŀ���õ���¼�
		elv.setOnChildClickListener(new OnChildClickListener() {

			@Override
			public boolean onChildClick(ExpandableListView parent, View v,
					int groupPosition, int childPosition, long id) {
				Map<String, String> map = (Map<String, String>) adapter
						.getChild(groupPosition, childPosition);
				String mobilephone = map.get("mobilephone");
				String shortnum = map.get("shortnum");
				// ����ѡ�񲦺ŶԻ���
				showSelectDialog(mobilephone, shortnum);
				// ֱ�Ӳ���
				// Intent intent = new Intent(Intent.ACTION_CALL);
				// intent.setData(Uri.parse("tel:" + mobilephone));
				// context.startActivity(intent);
				return false;
			}
		});
	}

	private void initTitleBar() {
		mTitleBar = (TitleBar) findViewById(R.id.titlebar);

		mTitleBar.changeStyle(STYLE.NOT_BTN_AND_TITLE);

		mTitleBar.centerTextView.setText("��ϵ���б�");
	}

	@Override
	protected void registerEvents() {
		// TODO Auto-generated method stub

	}
	
	protected void showSelectDialog(String longnum, String shortnum) {
		// TODO Auto-generated method stub
		// AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
		// dialogBuilder.setTitle("��ѡ�񲦺����ͣ�");
		// dialogBuilder.setView(View.inflate(context,
		// R.layout.ldt_selectdialog, dialogBuilder));
		SelectDialog dialog = new SelectDialog(mContext, longnum, shortnum);
		dialog.setTitle("��ѡ�񲦺�����");
		dialog.show();
	}
	
	public class SelectDialog extends Dialog {

		String longnum;
		String shortnum;

		public SelectDialog(Context context, String longnum, String shortnum) {
			super(context);
			this.longnum = longnum;
			this.shortnum = shortnum;
		}

		@Override
		protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			this.setContentView(R.layout.selectdialog);
			Button bt_long = (Button) this.findViewById(R.id.bt_long);
			Button bt_short = (Button) this.findViewById(R.id.bt_short);

			bt_long.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent = new Intent(Intent.ACTION_CALL);
					intent.setData(Uri.parse("tel:" + longnum));
					mContext.startActivity(intent);
				}
			});

			bt_short.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent = new Intent(Intent.ACTION_CALL);
					intent.setData(Uri.parse("tel:" + shortnum));
					mContext.startActivity(intent);
				}
			});
		}

	}
}
