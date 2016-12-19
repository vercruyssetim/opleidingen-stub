import gulp from "gulp";
import runSequence from "run-sequence";
import {prepare} from "../prepare/prepare";
import {eslint} from "./eslint";
import {testUnit} from "./karma";

export const test = 'test';

gulp.task(test, (callback) =>
    runSequence(
        prepare,
        [eslint],
        testUnit,
        callback)
);
