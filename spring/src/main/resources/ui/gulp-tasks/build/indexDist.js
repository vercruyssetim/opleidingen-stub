import gulp from "gulp";
import htmlReplace from "gulp-html-replace";
import {dirs, fileNames, files} from "../config";

export const indexDist = 'indexDist';

gulp.task(indexDist, () =>
    gulp.src(files.indexHtml)
        .pipe(htmlReplace({
            'jsBundle': fileNames.jsBundled
        }))
        .pipe(gulp.dest(dirs.dist))
);

