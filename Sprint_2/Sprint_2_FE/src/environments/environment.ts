// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

export const environment = {
  apiUrl : 'http://localhost:8080',
  production: false,
  firebaseConfig: {
    apiKey: 'AIzaSyAsRj7pNL6Ohja-tlRt93VC6YU0A0bbOaU',
    authDomain: 'toibithieunang-603db.firebaseapp.com',
    databaseURL: 'https://toibithieunang-603db-default-rtdb.firebaseio.com',
    projectId: 'toibithieunang-603db',
    storageBucket: 'toibithieunang-603db.appspot.com',
    messagingSenderId: '116750541685',
    appId: '1:116750541685:web:7ad5623dc24f65d82da93c',
    measurementId: 'G-6394YFE73X'
  },
  api_url_list_watch: 'http://localhost:8080/api/v1/watches',
  categoryUrl: 'http://localhost:8080/api/v1/watches/category',
  api_url_list_images: 'http://localhost:8080/api/v1/images',
  api_url_list_brand: 'http://localhost:8080/api/v1/watches/brand'
};

/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.
