package com.technotroop.mqttdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.nineoldandroids.animation.Animator;

public class UserRegisterActivity extends AppCompatActivity implements UserRegisterInterface {

    private RelativeLayout buttonEffect;

    private TextView tourTitle, tourMessage, btnMore, btnRegister;
    private EditText emailId, firstName, lastName, phoneNo;
    private ImageView imgWaterTank, imgRouter, imgIOS, imgAndroid, imgNotificationIOS, imgNotificationAndroid;
    private View linetitle;

    private Button btnBeginTour;

    private VerticalProgressBar progressBarWater;
    private UserRegisterController userRegisterController;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);

        tourTitle = (TextView) findViewById(R.id.textTourTitle);
        tourMessage = (TextView) findViewById(R.id.textTourMessage);
        btnMore = (TextView) findViewById(R.id.btnMore);
        btnRegister = (TextView) findViewById(R.id.btnRegister);

        emailId = (EditText) findViewById(R.id.editTextEmail);
        firstName = (EditText) findViewById(R.id.editTextFirstName);
        lastName = (EditText) findViewById(R.id.editTextLastName);
        phoneNo = (EditText) findViewById(R.id.editTextPhone);

        imgWaterTank = (ImageView) findViewById(R.id.imgWaterTank);
        imgRouter = (ImageView) findViewById(R.id.imgRouter);
        imgIOS = (ImageView) findViewById(R.id.imgDeviceIOS);
        imgAndroid = (ImageView) findViewById(R.id.imgDeviceAndroid);
        imgNotificationAndroid = (ImageView) findViewById(R.id.imgNotificationAndroid);
        imgNotificationIOS = (ImageView) findViewById(R.id.imgNotificationIOS);

        linetitle = findViewById(R.id.lineTitle);

        btnBeginTour = (Button) findViewById(R.id.btnBeginTour);
        buttonEffect = (RelativeLayout) findViewById(R.id.viewEffect);

        progressBarWater = (VerticalProgressBar) findViewById(R.id.progressWater);

        userRegisterController = new UserRegisterController();
        user = new User();

        Animation fadeOut = new AlphaAnimation(1, 0);
        fadeOut.setDuration(1000);

        Animation zoomIn = new ScaleAnimation(1, 4, 1, 4, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        zoomIn.setDuration(1000);

        final AnimationSet focusAnim = new AnimationSet(true);
        focusAnim.addAnimation(zoomIn);
        focusAnim.addAnimation(fadeOut);

        buttonEffect.startAnimation(focusAnim);

        focusAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                buttonEffect.startAnimation(focusAnim);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        btnBeginTour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (buttonEffect.getAnimation() != null) {
                    buttonEffect.setAnimation(null);
                    buttonEffect.setVisibility(View.GONE);
                    btnBeginTour.setVisibility(View.GONE);
                }

                tourTitle.setVisibility(View.VISIBLE);
                YoYo.with(Techniques.SlideInDown)
                        .duration(1000)
                        .withListener(new Animator.AnimatorListener() {
                            @Override
                            public void onAnimationStart(Animator animation) {

                            }

                            @Override
                            public void onAnimationEnd(Animator animation) {

                                linetitle.setVisibility(View.VISIBLE);
                                YoYo.with(Techniques.SlideInRight)
                                        .duration(1000)
                                        .withListener(new Animator.AnimatorListener() {
                                            @Override
                                            public void onAnimationStart(Animator animation) {

                                            }

                                            @Override
                                            public void onAnimationEnd(Animator animation) {
                                                imgWaterTank.setVisibility(View.VISIBLE);
                                                YoYo.with(Techniques.ZoomIn)
                                                        .duration(1500)
                                                        .withListener(new Animator.AnimatorListener() {
                                                            @Override
                                                            public void onAnimationStart(Animator animation) {

                                                            }

                                                            @Override
                                                            public void onAnimationEnd(Animator animation) {
                                                                imgRouter.setVisibility(View.VISIBLE);
                                                                YoYo.with(Techniques.SlideInRight)
                                                                        .duration(800)
                                                                        .withListener(new Animator.AnimatorListener() {
                                                                            @Override
                                                                            public void onAnimationStart(Animator animation) {

                                                                            }

                                                                            @Override
                                                                            public void onAnimationEnd(Animator animation) {
                                                                                imgIOS.setVisibility(View.VISIBLE);
                                                                                YoYo.with(Techniques.Shake)
                                                                                        .withListener(new Animator.AnimatorListener() {
                                                                                            @Override
                                                                                            public void onAnimationStart(Animator animation) {

                                                                                            }

                                                                                            @Override
                                                                                            public void onAnimationEnd(Animator animation) {
                                                                                                imgAndroid.setVisibility(View.VISIBLE);
                                                                                                YoYo.with(Techniques.Tada)
                                                                                                        .duration(1000)
                                                                                                        .withListener(new Animator.AnimatorListener() {
                                                                                                            @Override
                                                                                                            public void onAnimationStart(Animator animation) {

                                                                                                            }

                                                                                                            @Override
                                                                                                            public void onAnimationEnd(Animator animation) {
                                                                                                                tourMessage.setVisibility(View.VISIBLE);

                                                                                                                YoYo.with(Techniques.FadeIn)
                                                                                                                        .duration(1000)
                                                                                                                        .withListener(new Animator.AnimatorListener() {
                                                                                                                            @Override
                                                                                                                            public void onAnimationStart(Animator animation) {
                                                                                                                            }

                                                                                                                            @Override
                                                                                                                            public void onAnimationEnd(Animator animation) {
                                                                                                                                btnMore.setVisibility(View.VISIBLE);

                                                                                                                                YoYo.with(Techniques.RubberBand)
                                                                                                                                        .duration(1500)
                                                                                                                                        .playOn(btnMore);

                                                                                                                            }

                                                                                                                            @Override
                                                                                                                            public void onAnimationCancel(Animator animation) {

                                                                                                                            }

                                                                                                                            @Override
                                                                                                                            public void onAnimationRepeat(Animator animation) {

                                                                                                                            }
                                                                                                                        })
                                                                                                                        .playOn(tourMessage);
                                                                                                            }

                                                                                                            @Override
                                                                                                            public void onAnimationCancel(Animator animation) {

                                                                                                            }

                                                                                                            @Override
                                                                                                            public void onAnimationRepeat(Animator animation) {

                                                                                                            }
                                                                                                        }).playOn(imgAndroid);
                                                                                            }

                                                                                            @Override
                                                                                            public void onAnimationCancel(Animator animation) {

                                                                                            }

                                                                                            @Override
                                                                                            public void onAnimationRepeat(Animator animation) {

                                                                                            }
                                                                                        }).playOn(imgIOS);
                                                                            }

                                                                            @Override
                                                                            public void onAnimationCancel(Animator animation) {

                                                                            }

                                                                            @Override
                                                                            public void onAnimationRepeat(Animator animation) {

                                                                            }
                                                                        })
                                                                        .playOn(imgRouter);
                                                            }

                                                            @Override
                                                            public void onAnimationCancel(Animator animation) {

                                                            }

                                                            @Override
                                                            public void onAnimationRepeat(Animator animation) {

                                                            }
                                                        })
                                                        .playOn(imgWaterTank);
                                            }

                                            @Override
                                            public void onAnimationCancel(Animator animation) {

                                            }

                                            @Override
                                            public void onAnimationRepeat(Animator animation) {

                                            }
                                        })
                                        .playOn(linetitle);
                            }

                            @Override
                            public void onAnimationCancel(Animator animation) {

                            }

                            @Override
                            public void onAnimationRepeat(Animator animation) {

                            }
                        })
                        .playOn(tourTitle);
            }
        });

        btnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btnMore.setVisibility(View.GONE);

                tourMessage.setText(getString(R.string.tourMessage2));

                YoYo.with(Techniques.SlideInRight)
                        .duration(1500)
                        .withListener(new Animator.AnimatorListener() {
                            @Override
                            public void onAnimationStart(Animator animation) {

                            }

                            @Override
                            public void onAnimationEnd(Animator animation) {
                                imgNotificationAndroid.setVisibility(View.VISIBLE);
                                imgNotificationIOS.setVisibility(View.VISIBLE);

                                YoYo.with(Techniques.Flash)
                                        .duration(1000)
                                        .withListener(new Animator.AnimatorListener() {
                                            @Override
                                            public void onAnimationStart(Animator animation) {
                                                progressBarWater.setVisibility(View.VISIBLE);

                                                for (int i = 0; i < 75; i++) {
                                                    progressBarWater.setProgress(i);
                                                }
                                            }

                                            @Override
                                            public void onAnimationEnd(Animator animation) {

                                                YoYo.with(Techniques.Flash)
                                                        .duration(1000)
                                                        .playOn(imgNotificationIOS);

                                            }

                                            @Override
                                            public void onAnimationCancel(Animator animation) {

                                            }

                                            @Override
                                            public void onAnimationRepeat(Animator animation) {

                                            }
                                        })
                                        .playOn(imgNotificationAndroid);

                            }

                            @Override
                            public void onAnimationCancel(Animator animation) {

                            }

                            @Override
                            public void onAnimationRepeat(Animator animation) {

                            }
                        })
                        .playOn(tourMessage);
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setEmail(emailId.getText().toString());
                user.setFirstName(firstName.getText().toString());
                user.setLastName(lastName.getText().toString());
                user.setPhoneNumber(phoneNo.getText().toString());

                if (userRegisterController.isDataValidate(user) == UserValidation.TRUE) {
                    //TODO:proceed to service
                    userRegisterController.registerUser(user);

                } else if (userRegisterController.isDataValidate(user) == UserValidation.REQUIRED_EMAIL) {
                    emailId.setError(getString(R.string.required));
                    return;
                } else if (userRegisterController.isDataValidate(user) == UserValidation.REQUIRED_FIRSTNAME) {
                    firstName.setError(getString(R.string.required));
                    return;
                } else if (userRegisterController.isDataValidate(user) == UserValidation.REQUIRED_LASTNAME) {
                    lastName.setError(getString(R.string.required));
                    return;
                } else if (userRegisterController.isDataValidate(user) == UserValidation.REQUIRED_PHONE) {
                    phoneNo.setError(getString(R.string.required));
                    return;
                } else if (userRegisterController.isDataValidate(user) == UserValidation.INVALID_EMAIL) {
                    emailId.setError(getString(R.string.invalidEmail));
                    return;
                } else if (userRegisterController.isDataValidate(user) == UserValidation.INVALID_PHONE) {
                    phoneNo.setError(getString(R.string.invalidePhone));
                    return;
                }
            }
        });
    }

    @Override
    public void onSuccessUserRegister() {
        launchNextActivity(WaterLevelActivity.class);
    }

    @Override
    public void onErrorUserRegister() {

    }

    @Override
    public void onErrorNoConnection() {

    }

    private void launchNextActivity(Class calledClass) {
        Intent intent = new Intent(this, calledClass);
        startActivity(intent);
    }
}