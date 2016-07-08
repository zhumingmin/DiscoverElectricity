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
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class LeftFragment extends Fragment {
	private static final int msgKey1 = 1;
	private TextView shijian, shijian1, shijian2, shijian3;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.activity_message, null);
		shijian = (TextView) view.findViewById(R.id.shijian);
		shijian1 = (TextView) view.findViewById(R.id.shijian1);
		shijian2 = (TextView) view.findViewById(R.id.shijian2);
		shijian3 = (TextView) view.findViewById(R.id.shijian3);
		new TimeThread().start();
		return view;
	}

	public class TimeThread extends Thread {
		@Override
		public void run() {
			do {
				try {
					Thread.sleep(1000);
					Message msg = new Message();
					msg.what = msgKey1;
					mHandler.sendMessage(msg);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} while (true);
		}
	}

	private Handler mHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			switch (msg.what) {
			case msgKey1:
				long sysTime = System.currentTimeMillis();
				CharSequence sysTimeStr = DateFormat.format("yyyy年MM月dd日",
						sysTime);
				shijian.setText(sysTimeStr);
				shijian1.setText(sysTimeStr);
				shijian2.setText(sysTimeStr);
				shijian3.setText(sysTimeStr);
				break;

			default:
				break;
			}
		}
	};

	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}

}
