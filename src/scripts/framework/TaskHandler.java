package scripts.framework;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 * User: W. S. Newton
 * Date: 6/11/13
 * Time: 1:51 PM
 */

public final class TaskHandler {

	private final TaskSet taskSet;
	private final TaskQueue taskQueue;

	public TaskHandler (final Task... tasks) {
		this.taskSet = new TaskSet(Arrays.asList(tasks));
		this.taskQueue = new TaskQueue();
	}

	public void addEachTask (final Task... tasks) {
		this.taskSet.addAll(Arrays.asList(tasks));
	}

	public void removeEachTask (final Task... tasks) {
		this.taskSet.removeAll(Arrays.asList(tasks));
	}

	public void update () {
		this.taskQueue.addAll(getActiveTasks());
		if ( this.taskQueue.isEmpty() ) {
			return;
		}
		this.taskQueue.remove().execute();
	}

	private HashSet<Task> getActiveTasks () {
		final HashSet<Task> activeTasks = new HashSet<>();
		for ( final Task task : this.taskSet ) {
			if ( task.conditionMet() ) {
				activeTasks.add(task);
			}
		}
		return activeTasks;
	}

}
