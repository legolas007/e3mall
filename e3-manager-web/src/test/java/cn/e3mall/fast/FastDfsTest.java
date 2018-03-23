package cn.e3mall.fast;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

import cn.e3mall.common.utils.FastDFSClient;
import jdk.nashorn.internal.ir.annotations.Ignore;

public class FastDfsTest {
	

	public void testUpload() throws Exception {
		// 创建一个配置文件。文件名任意。内容就是tracker服务器的地址。
		// 使用全局对象加载配置文件。
		ClientGlobal.init("I:\\Django\\宜立方\\e3商城_day01\\黑马32期\\day01\\source\\e3-manager-web\\src\\main\\resources\\conf\\client.conf");
		// 创建一个TrackerClient对象
		TrackerClient trackerClient = new TrackerClient();

		// 通过TrackClient获得一个TrackerServer对象
		TrackerServer trackerServer = trackerClient.getConnection();
		// 创建一个StrorageServer的引用，可以是null
		StorageServer storageServer = null;
		// 创建一个StorageClient，参数需要TrackerServer和StrorageServer
		StorageClient storageClient = new StorageClient(trackerServer, storageServer);
		// 使用StorageClient上传文件。
		String[] strings = storageClient.upload_file("C://Users//24219//Desktop//9d52c073gy1fpieu81jr3j20p00vptod.jpg", "jpg", null);
		for (String string : strings) {
			System.out.println(string);
		}
	}
	@Test
	public void testFastDfsClient() throws Exception{
		FastDFSClient fastDFSClient = new FastDFSClient("I:\\Django\\宜立方\\e3商城_day01\\黑马32期\\day01\\source\\e3-manager-web\\src\\main\\resources\\conf\\client.conf");
		String string = fastDFSClient.uploadFile("C:\\Users\\24219\\Desktop\\3db714cf36dc2f1ed8846760c14a8e59.jpg");
		System.out.println(string);
	}

}
