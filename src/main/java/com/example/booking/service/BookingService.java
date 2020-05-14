package com.example.booking.service;



import com.example.booking.model.request.BookingUpdataRequest;
import com.example.booking.model.request.MeetingRoomRequest;
import com.example.booking.model.response.BookingResponse;
import com.example.booking.model.response.MeetingRoomResponse;

public interface BookingService {

    BookingResponse get(int id);

    String add(BookingUpdataRequest bookingUpdataRequest);

    String updata(BookingUpdataRequest bookingUpdataRequest);

    String delete(int id);




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
