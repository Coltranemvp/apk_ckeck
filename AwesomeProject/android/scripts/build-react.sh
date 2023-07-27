cd "../../"
mkdir -p "android/app/src/main/rn/assets"
mkdir -p "android/app/src/main/rn/res"
react-native bundle --platform android --dev false --entry-file index.js --bundle-output "android/app/src/main/rn/assets/index.android.bundle" --assets-dest "android/app/src/main/rn/res"