import gulp from "gulp";
import runSequence from "run-sequence";
import {cleanDist} from "./clean";
import {test} from "../test/test";
import {bundle} from "./bundle";
import {indexDist} from "./indexDist";

export const build = 'build';

gulp.task(build, callback =>
    runSequence(
        cleanDist,
        test,
        bundle,
        indexDist,
        callback)
);
