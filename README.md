Step one:
Add it in your root build.gradle at the end of repositories:
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

Step 2. Add the dependency
dependencies {
	        implementation 'com.github.adcenter-team:adcenter:v1.0'
	}

Step 3 : initialize SDK
In the first activity that is launched for the user:

override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

				AdCenter.initWithApkNormal(this,key)

}

key*:
برای راه اندازی گسترده شما نیاز به دریافت کلید از ادمین  دارید 
id telegram admin:@adcenter_support
