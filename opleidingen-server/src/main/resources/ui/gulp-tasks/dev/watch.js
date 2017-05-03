import gulp from "gulp";
import {files} from "../config";
import {prepareAssetsStylesheetsLess} from "../prepare/prepare";
import {eslint} from "../test/eslint";
import {testUnit} from "../test/karma";
import {browserSyncServer} from "./serve";

export const watch = 'watch';
export const bsReload = 'bs-reload';

gulp.task(watch, () => {
  gulp.watch(files.js, [eslint, testUnit]);
  gulp.watch(files.less, [prepareAssetsStylesheetsLess]);
  gulp.watch(files.html, [bsReload]);
});

gulp.task(bsReload, function () {
  browserSyncServer.reload();
});
