cd "../../../"
echo "Working at $(pwd)"

mkdir -p "android/app/src/main/assets"
mkdir -p "android/app/src/main/res-rn"

npm install
npm i -g react-native-cli

react-native bundle --platform android --dev false --entry-file index.js --bundle-output "android/app/src/main/assets/index.android.bundle" --assets-dest "android/app/src/main/res-rn"