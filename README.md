# VerifyBlocksView
Android view for providing blocks (Edit Texts) to achieve verification process.
This view is enhanced with move to next view when user enter a value in edit text. Providing some methods for controlling value in verification view 

|Screenshot|Video Demo|
|---|---|
|<img src="https://github.com/sh3lan93/VerifyBlocksView/blob/master/device-2017-11-23-145733.png" width="350">|<img src="https://github.com/sh3lan93/VerifyBlocksView/blob/master/device_gif.gif" width="350">|

## Usage
### Adding Dependency 
Add this to ```build.gradle``` Project level 
```
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' 
    }
   }
 }
```
Add this to ``` build.gradle ``` Module:app
```
dependencies {
  compile 'com.github.sh3lan93:VerifyBlocksView:1.2'
}
```

for maven usage
```
<repositories>
    <repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
		</repository>
</repositories>
```
and then add dependency
```
<dependency>
    <groupId>com.github.sh3lan93</groupId>
    <artifactId>VerifyBlocksView</artifactId>
    <version>1.2</version>
</dependency>
```
### Adding The View
- XML
```xml
<com.shalan.mohamed.verificationview.VerifyView
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:id="@+id/verifyView"
    android:layout_marginTop="8dp"
    app:layout_constraintEnd_toEndOf="parent"
    app:layout_constraintStart_toStartOf="parent"
    app:layout_constraintTop_toTopOf="parent"
    app:num_of_blocks="6"
    app:blocks_text_color="@android:color/holo_blue_bright"
    />
```
- Java
```java
verifyView = findViewById(R.id.verifyView);
String codeText = verifyView.getTextEntered();
verifyView.setBlockHint(R.string._1);
verifyView.getBlockValue("1");
ArrayList<String> valuesEntered = verifyView.getValues();
verifyView.setBlockValueListener(new BlocksValuesListener() {
        @Override
        public void onValueChange(String value, String tag) {
          //value is the value entered in focused block
          //tag is the number of focused block e.g: block number 0
          //start blocks number = 0, end blocks number is number_of_blocks - 1
        }
});
```
### XML attributes
|Attribute|Description|
|---|---|
|app:num_of_blocks| Define the number of blocks you want to be displayed|
|app:blocks_text_color| Define the text color of verification blocks|

### Java Methods
|Method|Description|
|---|---|
|setViewTextTypeFace(AssetManager manager, String path)| set the font of verification blocks |
|ArrayList<String> getValues() | return array of texts in verification blocks |
|String getBlockValue(String tag) | return the text value for a given verification block number e.g: 0, 1|
|setBlockValueListener(BlocksValuesListener blockValueListener)| for setting listener for getting the last value entered while user entering text|
|setBlockHint(String hint)| for setting the hint of verification blocks|
|setBlockHint(@StringRes int hint)| for setting the hint of verification blocks|
|String getTextEntered()| for getting all texts entered in verification blocks e.g: 12345| 
  
## License

```
Copyright 2017 Mohamed Fotouh Shalan

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
