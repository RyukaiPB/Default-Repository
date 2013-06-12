package scripts.framework;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: W. S. Newton
 * Date: 6/12/13
 * Time: 2:57 PM
 */

public final class TaskSet extends HashSet<Task> {

	public TaskSet (List<Task> tasks) {
		for ( final Task task : tasks ) {
			if ( task != null ) {
				add(task);
			}
		}
	}

	@Override
	public boolean addAll (Collection<? extends Task> c) {
		for ( final Task task : c ) {
			if ( task == null || this.contains(task) ) {
				continue;
			}
			if ( ! add(task) ) {
				return false;
			}
		}
		return true;
	}

}
