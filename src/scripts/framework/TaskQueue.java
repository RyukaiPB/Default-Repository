package scripts.framework;

import java.util.Collection;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * User: W. S. Newton
 * Date: 6/12/13
 * Time: 2:53 PM
 */

public final class TaskQueue extends PriorityQueue<Task> {

	@Override
	public boolean addAll (Collection<? extends Task> c) {
		for ( final Task task : c ) {
			if ( task == null || this.contains(task)) {
				continue;
			}
			if ( ! add(task) ) {
				return false;
			}
		}
		return true;
	}

}
