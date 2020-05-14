package com.example.booking.service;



import com.example.booking.model.request.UserRequest;
import com.example.booking.model.response.UserResponse;

import java.util.List;

public interface UserService {

    UserResponse get(int id);

    String add(UserRequest userRequest);

    String updata(UserRequest userRequest);

    Boolean account(String account);




//    UserDevResponseV2_1 getUserV2_1(int id);
//
//    UserListResponseV2_1 getUserListV2_1(String keyword, List<Integer> teamIdList, int pageNumber, int pageSize);
//
//    void updateV2_1(UserUpdateRequestV2_1 request);
//
//    @Deprecated
//    Page<UserListResponse> getUserList(SearchUserRequest model);
//
//    @Deprecated
//    UserDevResponse getUser(int id);
//
//    @Deprecated
//    void update(UserUpdateRequest request);
//
//    void addUserByLdap(List<String> accounts);
//
//    List<String> getPermission();
//
////    Boolean insertGroupPay(UserPayRequest model) throws Exception;
////
////    Boolean insertGroupPayTotal(UserPayTotalRequest model) throws Exception;
//
//
//    List<RoleResponse> getRole();
//
//    List<UserAllListResponse> getAllUserList();
}
