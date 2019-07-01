/*
 * aet-extensions: lighthouse
 *
 * Copyright (C) 2019 Maciej Laskowski
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.github.skejven.comparator;

import com.github.skejven.comparator.score.LighthouseScores;
import com.github.skejven.comparator.score.LighthouseScoresDiff;
import com.github.skejven.comparator.score.LighthouseScoresDiff.Builder;

class LighthouseReportAnalyser {

  LighthouseComparisonResult compare(LighthouseScores pattern, LighthouseScores current) {
    LighthouseScoresDiff diff = Builder.aLighthouseScoresDiff()
        .withPerformanceDiff(diff(pattern.getPerformance(), current.getPerformance()))
        .withAccessibilityDiff(diff(pattern.getAccessibility(), current.getAccessibility()))
        .withBestPracticesDiff(diff(pattern.getBestPractices(), current.getBestPractices()))
        .withSeoDiff(diff(pattern.getSeo(), current.getSeo()))
        .build();

    return new LighthouseComparisonResult(pattern, current, diff);
  }

  private double diff(double pattern, double current) {
    return current - pattern;
  }

}