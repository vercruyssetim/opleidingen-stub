import gulp from "gulp";
import runSequence from "run-sequence";
import del from "del";
import sourcemaps from "gulp-sourcemaps";
import less from "gulp-less";
import LessPluginAutoPrefix from "less-plugin-autoprefix";
import {ngConstant} from "./ngConstant";
import {paths, files, fileGroups} from "../config";

const autoprefix = new LessPluginAutoPrefix({ browsers: ["last 2 versions"] });

export const prepare = 'prepare';
export const cleanAssets = 'clean:assets';
export const prepareAssets = 'prepare:assets';
export const prepareAssetsStylesheetsLess = 'prepare:assets:stylesheets:less';
export const prepareAssetsStylesheetsBootstrap = 'prepare:assets:stylesheets:bootstrap';

gulp.task(prepare, callback =>
  runSequence(
    cleanAssets,
    [prepareAssets, ngConstant],
    callback)
);

gulp.task(cleanAssets, callback =>
  del(fileGroups.cleanAssets, callback)
);

gulp.task(prepareAssets, [prepareAssetsStylesheetsLess, prepareAssetsStylesheetsBootstrap]);

gulp.task(prepareAssetsStylesheetsLess, () =>
  gulp
    .src(files.lessMain)
    .pipe(sourcemaps.init())
    .pipe(less({
      paths: [ files.less],
      plugins: [autoprefix]
    }))
    .pipe(sourcemaps.write('.'))
    .pipe(gulp.dest(paths.css))
);

gulp.task(prepareAssetsStylesheetsBootstrap, () =>
    gulp
        .src(files.lessBootstrapMain)
        .pipe(sourcemaps.init())
        .pipe(less({
            paths: [ files.lessBootstrap],
            plugins: [autoprefix]
        }))
        .pipe(sourcemaps.write('.'))
        .pipe(gulp.dest(paths.css))
);
