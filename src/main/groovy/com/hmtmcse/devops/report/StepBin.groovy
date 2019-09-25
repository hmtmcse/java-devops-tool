package com.hmtmcse.devops.report

class StepBin {

    public String taskName = ""
    public List<Step> steps = []
    public List<StepBin> otherSteps = []

    public StepBin addStep(Step step){
        steps.add(step)
        return this
    }
}
