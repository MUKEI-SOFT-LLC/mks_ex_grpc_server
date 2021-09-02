package jp.co.mukeisoftllc.examples.grpc.servers;
import org.lognet.springboot.grpc.GRpcService;
import jp.co.mukeisoftllc.ex.protobuf.EchoRequest;
import jp.co.mukeisoftllc.ex.protobuf.EchoResponse;
import jp.co.mukeisoftllc.ex.protobuf.EchoServiceGrpc;

@GRpcService
public class EchoService extends EchoServiceGrpc.EchoServiceImplBase {
    @Override
    public void echo(EchoRequest request, io.grpc.stub.StreamObserver<EchoResponse> responseObserver) {
        responseObserver.onNext(
            EchoResponse
                .newBuilder()
                .setMessage(
                    String.format("%s %d length.", request.getMessage(), request.getMessage().length()))
                .build()
        );
        responseObserver.onCompleted();
    }
}
