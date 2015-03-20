说明：
１、此工程是第三方系统与MDM交互示例工程，不依赖于ESB，数据从Excel装载，分发数据直接写入文本文件
２、包com.yonyou.itf.mdm07.sharing中包含与MDM交互的ＷＳ标准接口，不要进行任何变更
３、第三方系统实现IMdSharingThirdPartService，并给实现类加上以下注解：非常重要！！！
@WebService(name="IMdSharingThirdPartService", serviceName="IMdSharingThirdPartService", targetNamespace="http://sharing.mdm07.itf.yonyou.com/")
４、实现分发接口方法（distributeMd）时，要返回业务数据ＩＤ与主数据之间的映射关系，重要！！！
５、本示例使用JDK标准接口发布ＷＳ（见Server类），用户可以使用其他方式，如ESB,CXF等，
但要注意发布的ＷＳ属性要与3中注解保持一致。
６、第三方系统与MDM交互中，主数据格式为json，可以使用工具包gson-2.2.2.jar；
７、本示例从Excel中读取数据，用户可以自行准备数据，但要注意主数据的属性要与MDM中的模型一致。