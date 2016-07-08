/*
 * Copyright (C) 2012 yueyueniao
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.fragment;

import com.example.discoverelectricity.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RightFragment extends Fragment {
	private Button bangding;
	private EditText tianxiexuehao, tianxiemima;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.activity_account, null);
		bangding = (Button) view.findViewById(R.id.bangding);
		tianxiexuehao = (EditText) view.findViewById(R.id.tianxiexuehao);
		tianxiexuehao = (EditText) view.findViewById(R.id.tianxiemima);
		bangding.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (tianxiexuehao.getText().toString().equals("")) {
					Toast.makeText(getActivity(), "学号不能为空！", 0).show();
					return;
				}
				if (tianxiexuehao.getText().toString().equals("")) {
					Toast.makeText(getActivity(), "密码不能为空！", 0).show();
					return;
				}
				Toast.makeText(getActivity(), "绑定成功！", 0).show();

				// getActivity().finish();
			}
		});
		return view;
	}

	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}

}
