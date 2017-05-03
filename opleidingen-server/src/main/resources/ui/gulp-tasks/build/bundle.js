import gulp from "gulp";
import sourcemaps from "gulp-sourcemaps";
import jspm from "gulp-jspm";
import {dirs, files} from "../config";

export const bundle = 'bundle';

gulp.task(bundle, () =>
    gulp.src(files.bundleRoot)
        .pipe(sourcemaps.init())
        .pipe(jspm({
            selfExecutingBundle: true
        }))
        .pipe(sourcemaps.write('.'))
        .pipe(gulp.dest(dirs.dist))
);
