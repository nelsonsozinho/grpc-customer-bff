package br.com.shire42.customerbff.grpc.client;

import br.com.shire42.customerbff.model.Card;
import br.com.shire42.customerbff.model.Wallet;
import br.com.shire42.wallet.ProtoWalletList;
import br.com.shire42.wallet.WalletRequest;
import br.com.shire42.wallet.WalletServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalletGrpcClient {

    @GrpcClient("wallet-service")
    private WalletServiceGrpc.WalletServiceBlockingStub walletStub;

    public List<Wallet> findWalletsCustomer(final String customerId) {
        final ProtoWalletList walletList = walletStub.findWalletsByCustomer(WalletRequest.newBuilder()
                .setCustomerId(customerId)
                .build());

        return walletList.getWalletsList().stream().map(w -> Wallet.builder()
                .name(w.getWalletName())
                .description(w.getDescription())
                .resource(w.getCash())
                .cards(w.getCardsList().stream().map(c -> Card.builder()
                        .cvc(c.getCvc())
                        .holder(c.getHolderName())
                        .number(c.getNumber())
                        .expiration(c.getExpire())
                        .build()
                ).toList())
                .build()
        ).toList();
    }

}
