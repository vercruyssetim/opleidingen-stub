import gulp from "gulp";
import gulpEslint from "gulp-eslint";
import fs from "fs";
import {files} from "../config";

export const eslint = 'eslint';

gulp.task(eslint, () =>
    gulp.src([files.gulp, files.js])
        .pipe(gulpEslint({
            configFile: files.esLint
        }))
        .pipe(gulpEslint.format())
        .pipe(gulpEslint.failAfterError())
);
