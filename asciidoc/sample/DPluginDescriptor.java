package __PACKAGE__;

import com.hmtmcse.devops.data.TaskReport;
import com.hmtmcse.devops.system.skeleton.PluginDefinition;
import com.hmtmcse.devops.system.skeleton.TaskInput;
import com.hmtmcse.devops.system.skeleton.TaskProgress;
import com.hmtmcse.devops.system.common.DevOpsException;

public class __NAME__Descriptor implements PluginDefinition<__NAME__> {

    public static final String action = "__REGISTRATION_NAME__";

    @Override
    public TaskReport executeTask(TaskInput<__NAME__> taskInput) {
        System.out.println("Yes Buddy: __NAME__Descriptor");
        return null;
    }

    @Override
    public TaskReport executeTask(TaskInput<MakeDir> taskInput, TaskProgress taskProgress) throws DevOpsException {
        System.out.println("Yes Buddy: __NAME__Descriptor");
        return null;
    }

    @Override
    public Class<?> dataClass() {
        return __NAME__Input.class;
    }

    @Override
    public TaskInput<__NAME__> dataFullExample() {
        __NAME__Input input = new __NAME__Input();
        input.action = __NAME__Descriptor.action;
        input.operation = "Example of __NAME__ Plugin.";
        return input;
    }
}
