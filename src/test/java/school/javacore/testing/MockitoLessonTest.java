package school.javacore.testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MockitoLessonTest {
    @Test
    public void shouldSaveUserReturnCorrectResultWhenSaveUserRepositorySuccess() {
        // given
        UserRepository userRepositoryMock = mock(UserRepository.class);
        User dummyUser = new User(1, "Alice");
        when(userRepositoryMock.saveUser(dummyUser)).thenReturn(true);

        UserService userService = new UserService(userRepositoryMock);

        // when
        boolean result = userService.saveUser(dummyUser);

        // then
        assertEquals(result, Boolean.TRUE);
        verify(userRepositoryMock, times(1)).saveUser(dummyUser);
    }

    @Test
    public void shouldSaveUserReturnCorrectResultWhenSaveUserRepositoryFailure() {
        // given
        UserRepository userRepositoryMock = mock(UserRepository.class);
        User dummyUser = new User(1, "Alice");
        when(userRepositoryMock.saveUser(dummyUser)).thenReturn(false);
        UserService userService = new UserService(userRepositoryMock);

        // when
        boolean result = userService.saveUser(dummyUser);

        // then
        assertEquals(result, Boolean.FALSE);
        verify(userRepositoryMock, times(1)).saveUser(dummyUser);
    }
}