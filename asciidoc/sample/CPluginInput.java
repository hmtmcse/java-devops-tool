package __PACKAGE__;

import com.hmtmcse.devops.system.skeleton.TaskInput;

public class __NAME__Input implements TaskInput<__NAME__> {

    public String action;
    public String operation;
    public __NAME__ input = new __NAME__();

    @Override
    public String getAction() {
        return action;
    }

    @Override
    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public String getOperation() {
        return operation;
    }

    @Override
    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Override
    public __NAME__ getInput() {
        return input;
    }

    @Override
    public void setInput(__NAME__ input) {
        this.input = input;
    }
}
