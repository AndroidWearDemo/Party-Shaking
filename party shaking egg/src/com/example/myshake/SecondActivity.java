
package com.example.myshake;

import java.util.Random;

import com.example.myshake.ShakeListener.OnShakeListener;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;

public class SecondActivity extends Activity {

	private Vibrator vibrator;//��
	/** ҡ֮ǰ ң֮�� ,���ص� */
	private ImageView imView, imcount, imgnot;
/**����*/
	private ShakeListener shakeListener;
	
private	int ico[] = { R.drawable.image_left, R.drawable.image_middle,R.drawable.image_right };

private	int icoSotp[] = { R.drawable.lottery_result,R.drawable.lottery_nothing,R.drawable.chengfa1,
							R.drawable.chengfa2,R.drawable.chengfa3,R.drawable.chengfa4,R.drawable.chengfa5,
							R.drawable.chengfa6,R.drawable.chengfa7,R.drawable.chengfa8,R.drawable.chengfa9,
							R.drawable.chengfa10,R.drawable.chengfa11,R.drawable.chengfa12,R.drawable.chengfa13};

private	int index = 0;

private int randomC=0;

private Random random;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.shake2);
		init();
	}
	
	public void init(){
		vibrator = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);
		shakeListener = new ShakeListener(this);
		shakeListener.setOnShake(onShake);

		imView = (ImageView) this.findViewById(R.id.imgmiddle);
		imcount = (ImageView) this.findViewById(R.id.imgtit);
		imgnot = (ImageView) this.findViewById(R.id.imgnoth);
		random=new Random();
	}

	/** ������Ӧ */
	private OnShakeListener onShake = new OnShakeListener() {

		@Override
		public void onShake() {
			imgnot.setVisibility(View.GONE);

			startVibrator();
			shakeListener.stop();

			handler.sendEmptyMessageDelayed(1, 200);
			handler.sendEmptyMessageDelayed(2, 2000);
			
			randomC=random.nextInt(15);
			Log.e("--", "---"+randomC);

		}
	};

	private Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			if (msg.what == 1) {
				if (index < ico.length - 1) {
					index++;
				} else {
					index = 0;
				}
				imView.setBackgroundResource(ico[index]);
				handler.sendEmptyMessageDelayed(1, 200);
			} else {
				imView.setBackgroundResource(icoSotp[0]);
				//imcount.setBackgroundResource(icoSotp[1]);
				handler.removeMessages(1);
				shakeListener.start();
				//������ start
				
				
				if(randomC==1){
					imgnot.setBackgroundResource(icoSotp[3]);
					imgnot.setVisibility(View.VISIBLE);
				}
				else if(randomC==2){
					imgnot.setBackgroundResource(icoSotp[4]);
					imgnot.setVisibility(View.VISIBLE);
				}
				else if(randomC==3){
					imgnot.setBackgroundResource(icoSotp[5]);
					imgnot.setVisibility(View.VISIBLE);
				}
				else if(randomC==4){
					imgnot.setBackgroundResource(icoSotp[6]);
					imgnot.setVisibility(View.VISIBLE);
				}
				else if(randomC==5){
					imgnot.setBackgroundResource(icoSotp[7]);
					imgnot.setVisibility(View.VISIBLE);
				}
				else if(randomC==6){
					imgnot.setBackgroundResource(icoSotp[8]);
					imgnot.setVisibility(View.VISIBLE);
				}
				else if(randomC==7){
					imgnot.setBackgroundResource(icoSotp[9]);
					imgnot.setVisibility(View.VISIBLE);
				}
				else if(randomC==8){
					imgnot.setBackgroundResource(icoSotp[10]);
					imgnot.setVisibility(View.VISIBLE);
				}
				else if(randomC==9){
					imgnot.setBackgroundResource(icoSotp[11]);
					imgnot.setVisibility(View.VISIBLE);
				}
				else if(randomC==10){
					imgnot.setBackgroundResource(icoSotp[12]);
					imgnot.setVisibility(View.VISIBLE);
				}
				else if(randomC==11){
					imgnot.setBackgroundResource(icoSotp[13]);
					imgnot.setVisibility(View.VISIBLE);
				}
				else if(randomC==12){
					imgnot.setBackgroundResource(icoSotp[14]);
					imgnot.setVisibility(View.VISIBLE);
				}
				else if(randomC==13){
					imgnot.setBackgroundResource(icoSotp[1]);
					imgnot.setVisibility(View.VISIBLE);
				}
				else{
					imgnot.setBackgroundResource(icoSotp[2]);
					imgnot.setVisibility(View.VISIBLE);
				}
				
				
				
				
				
				//������ end
         
			}
		}

	};

	/**
	 * ������Ч��
	 */
	public void startVibrator() {
		vibrator.vibrate(new long[] { 500, 300, 500, 300 }, -1);
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}
	
	
	
}
