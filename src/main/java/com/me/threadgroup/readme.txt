�߳�����Ϣ�Ļ�ȡ
public int activeCount(); // ��õ�ǰ�߳������߳���Ŀ�� ���������кͲ������е�
public int activeGroupCount()�� //��õ�ǰ�߳����л�����߳������Ŀ
public int enumerate��Thread list[]��; //�оٵ�ǰ�߳����е��߳�
public int enumerate��ThreadGroup list[]���� //�оٵ�ǰ�߳����е����߳���
public final int getMaxPriority����; //��õ�ǰ�߳�����������ȼ�
public final String getName������ //��õ�ǰ�߳��������
public final ThreadGroup getParent����; //��õ�ǰ�߳���ĸ��߳���
public boolean parentOf��ThreadGroup g���� //�жϵ�ǰ�߳����Ƿ�Ϊָ���̵߳ĸ��߳�
public boolean isDaemon����; //�жϵ�ǰ�߳������Ƿ��м໤�߳�
public void list����; //�г���ǰ�߳����������̺߳����߳���

�߳���Ĳ���
public final void resume������ //ʹ������ĵ�ǰ���ڵ��ָ̻߳���������״̬
public final void setDaemon (boolean daemon); //ָ��һ���߳�Ϊ��ǰ�߳���ļ໤�߳�
public final void setMaxPriority��int pri���� //���õ�ǰ�߳��������������ȼ�
public final void stop������//��ֹ��ǰ�߳����������߳�
public final void suspend����; //����ǰ�߳����������߳�
public String toStrinng����; //����ǰ�߳���ת��ΪString��Ķ���