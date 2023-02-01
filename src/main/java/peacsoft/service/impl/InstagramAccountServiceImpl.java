package peacsoft.service.impl;

import peacsoft.entity.InstagramAccount;
import peacsoft.repositories.InstagramAccountRepositories;
import peacsoft.repositories.impl.InstagramAccountImpl;
import peacsoft.service.InstagramAccountService;

import java.util.List;

public class InstagramAccountServiceImpl implements InstagramAccountService {
    InstagramAccountRepositories instagramAccountRepositories = new InstagramAccountImpl();
    @Override
    public String saveAccount(InstagramAccount instagramAccount) {
        return instagramAccountRepositories.saveAccount(instagramAccount);
    }

    @Override
    public InstagramAccount getAccountById(Long accountId) {
        return instagramAccountRepositories.getAccountById(accountId);
    }

    @Override
    public List<InstagramAccount> getAllAccounts() {
        return instagramAccountRepositories.getAllAccounts();
    }

    @Override
    public String updateAccount(Long accountID, InstagramAccount instagramAccount) {
        return instagramAccountRepositories.updateAccount(accountID,instagramAccount);
    }

    @Override
    public String deleteAccountById(Long accountId) {
        return instagramAccountRepositories.deleteAccountById(accountId);
    }

    @Override
    public String changePassword(Long accountId, String newPassword) {
        return instagramAccountRepositories.changePassword(accountId,newPassword);
    }

    @Override
    public void assignPostToInstagramAccount(Long accountId, Long postId) {
        instagramAccountRepositories.assignPostToInstagramAccount(accountId,postId);
    }

    @Override
    public void assignUserToInstagramAccount(Long accountId, Long userId) {
        instagramAccountRepositories.assignUserToInstagramAccount(accountId,userId);
    }
}
