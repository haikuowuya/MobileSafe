package com.lilosoft.xtcm.views;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lilosoft.xtcm.R;

/**
 * @category �Զ���ȴ���
 * @author William Liu
 *
 */
public class MPProgressBar extends RelativeLayout {

	private ProgressBar progressBar;
	private TextView tvTipMsg;
	private TextView tvEllipsis;
	private Context mContext;
	private LayoutInflater mInflater;

	public MPProgressBar(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	public MPProgressBar(Context context) {
		super(context);
		init(context);
	}
	public MPProgressBar(Context context, int mStyle) {
		super(context);
		init(context);
	}

	private void init(Context context) {
		this.mContext = context;
		mInflater = LayoutInflater.from(mContext);
		mInflater.inflate(R.layout.view_mp_progressbar, this);
		
		progressBar = (ProgressBar) findViewById(R.id.progressBar);
		tvTipMsg = (TextView) findViewById(R.id.tvTipMsg);
		tvEllipsis = (TextView) findViewById(R.id.tvEllipsis);
		
		tvTipMsg.setTextColor(Color.WHITE);
		tvEllipsis.setTextColor(Color.WHITE);
	}
	
	/**
	 * ����Style
	 * @param style
	 */
	public void setProgressBarStyle(int style) {
		progressBar.setScrollBarStyle(style);
	}
	
	/**
	 * ������ʾ��Ϣ
	 * @param tipMsg
	 */
	public void setTextTipMsg (CharSequence tipMsg) {
		tvTipMsg.setText(tipMsg);
	}
	
	/**
	 * �������ֺ����ʡ�Ժţ��磺ͨ���С�
	 * @param ellipsis
	 */
	public void setTextEllipsis (CharSequence ellipsis) {
		tvEllipsis.setText(ellipsis);
	}
	
	/**
	 * ����������ɫ
	 * @param textColor
	 */
	public void setTextColorTipMsg (int textColor) {
		tvTipMsg.setTextColor(textColor);
		tvEllipsis.setTextColor(textColor);
	}
	
	/**
	 * ���������С
	 * @param textSize
	 */
	public void setTextSizeTipMsg (float  textSize) {
		tvTipMsg.setTextSize(textSize);
		tvEllipsis.setTextSize(textSize);
	}

}
