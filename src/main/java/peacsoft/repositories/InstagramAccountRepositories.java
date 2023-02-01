package peacsoft.repositories;

import peacsoft.entity.InstagramAccount;

import java.util.List;

public interface InstagramAccountRepositories {
    String saveAccount(InstagramAccount instagramAccount);
    InstagramAccount getAccountById(Long accountId);

    List<InstagramAccount> getAllAccounts();

    String updateAccount(Long accountID, InstagramAccount instagramAccount);

    String deleteAccountById(Long accountId);

    String changePassword(Long accountId, String newPassword);

    void assignPostToInstagramAccount(Long accountId,Long postId);
    void assignUserToInstagramAccount(Long accountId,Long userId);

}
