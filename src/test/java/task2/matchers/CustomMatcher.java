package task2.matchers;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

public class CustomMatcher extends TypeSafeDiagnosingMatcher<Integer> {

    @Override
    protected boolean matchesSafely(Integer item, Description mismatchDescription) {
        return (item.intValue() > 10 && item.intValue() < 100 && item.intValue() != 50);
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("this is not reasonable num for navigation side bar");
    }

    public static CustomMatcher isReasonableNum() {
        return new CustomMatcher();
    }
}
