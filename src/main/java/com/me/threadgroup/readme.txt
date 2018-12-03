线程组信息的获取
public int activeCount(); // 获得当前线程组中线程数目， 包括可运行和不可运行的
public int activeGroupCount()； //获得当前线程组中活动的子线程组的数目
public int enumerate（Thread list[]）; //列举当前线程组中的线程
public int enumerate（ThreadGroup list[]）； //列举当前线程组中的子线程组
public final int getMaxPriority（）; //获得当前线程组中最大优先级
public final String getName（）； //获得当前线程组的名字
public final ThreadGroup getParent（）; //获得当前线程组的父线程组
public boolean parentOf（ThreadGroup g）； //判断当前线程组是否为指定线程的父线程
public boolean isDaemon（）; //判断当前线程组中是否有监护线程
public void list（）; //列出当前线程组中所有线程和子线程名

线程组的操作
public final void resume（）； //使被挂起的当前组内的线程恢复到可运行状态
public final void setDaemon (boolean daemon); //指定一个线程为当前线程组的监护线程
public final void setMaxPriority（int pri）； //设置当前线程组允许的最大优先级
public final void stop（）；//终止当前线程组中所有线程
public final void suspend（）; //挂起当前线程组中所有线程
public String toStrinng（）; //将当前线程组转换为String类的对象