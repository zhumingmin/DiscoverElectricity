package com.example.fragment;

import com.example.discoverelectricity.AChartExample;

import com.example.discoverelectricity.R;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class PageFragment1 extends Fragment {
	private Spinner sp_leixing, sp_diqu, sp_sushe, sp_yuefen;

	private Button baobiao;
	private EditText chaxunjieguo;
	private TextView fangwen, chakanxiaoxi, bangdingzhanghao;
	private CustomArrayAdapter<CharSequence> mAdapter;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.activity_main, null);
		baobiao = (Button) view.findViewById(R.id.baobiao);
		chaxunjieguo = (EditText) view.findViewById(R.id.chaxunjieguo);
		fangwen = (TextView) view.findViewById(R.id.fangwenshuidianguanlike);

		String[] kexuanleixing = getResources().getStringArray(R.array.item1);
		this.mAdapter = new CustomArrayAdapter<CharSequence>(getActivity(),
				kexuanleixing);
		String[] kexuandiqu = getResources().getStringArray(R.array.item2);
		this.mAdapter = new CustomArrayAdapter<CharSequence>(getActivity(),
				kexuandiqu);
		String[] kexuansushe = getResources().getStringArray(R.array.item3);
		this.mAdapter = new CustomArrayAdapter<CharSequence>(getActivity(),
				kexuansushe);
		String[] kexuanyuefen = getResources().getStringArray(R.array.item4);
		this.mAdapter = new CustomArrayAdapter<CharSequence>(getActivity(),
				kexuanyuefen);

		sp_leixing = (Spinner) view.findViewById(R.id.leixing);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_spinner_dropdown_item, kexuanleixing);
		sp_leixing.setAdapter(adapter);
		sp_leixing
				.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {

					@Override
					public void onItemSelected(AdapterView<?> arg0, View arg1,
							int arg2, long arg3) {
						// TODO Auto-generated method stub
						arg0.setVisibility(View.VISIBLE);
					}

					@Override
					public void onNothingSelected(AdapterView<?> arg0) {
						// TODO Auto-generated method stub

					}

				});

		sp_diqu = (Spinner) view.findViewById(R.id.diqu);
		ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_spinner_dropdown_item, kexuandiqu);
		sp_diqu.setAdapter(adapter1);
		sp_diqu.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				arg0.setVisibility(View.VISIBLE);
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}

		});

		sp_sushe = (Spinner) view.findViewById(R.id.sushe);
		ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_spinner_dropdown_item, kexuansushe);
		sp_sushe.setAdapter(adapter2);
		sp_sushe.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				arg0.setVisibility(View.VISIBLE);
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}

		});

		sp_yuefen = (Spinner) view.findViewById(R.id.yuefen);
		ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_spinner_dropdown_item, kexuanyuefen);
		sp_yuefen.setAdapter(adapter3);
		sp_yuefen
				.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {

					@Override
					public void onItemSelected(AdapterView<?> arg0, View arg1,
							int arg2, long arg3) {
						// TODO Auto-generated method stub
						arg0.setVisibility(View.VISIBLE);

					}

					@Override
					public void onNothingSelected(AdapterView<?> arg0) {
						// TODO Auto-generated method stub

					}

				});

		baobiao.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent achartIntent = new AChartExample()
						.execute(getActivity());
				startActivity(achartIntent);
			}
		});
		fangwen.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent it = new Intent(Intent.ACTION_VIEW);
				it.setData(Uri
						.parse("http://web.scau.edu.cn/hqglc/newweb/org/orglist.asp?id=16")); // 这里面是需要调转的rul
				it = Intent.createChooser(it, null);
				startActivity(it);
			}
		});

		return view;
	}

	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}

	class CustomArrayAdapter<T> extends ArrayAdapter<T> {
		public CustomArrayAdapter(Context ctx, T[] objects) {
			super(ctx, android.R.layout.simple_spinner_dropdown_item, objects);
		}

	}

}
