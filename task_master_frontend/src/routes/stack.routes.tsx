import {
  createStackNavigator,
  StackNavigationProp,
} from "@react-navigation/stack";

import { SignIn } from "../screens/SignIn";
import { SignUp } from "../screens/SignUp";
import { HomeScreen } from "../screens/HomeScreen";
import { DrawerRoutes } from "./drawer.routes";

export type StackParamList = {
  SignIn: undefined;
  SignUp: undefined;
  Drawer: undefined;
};

export type StackNavigation = StackNavigationProp<StackParamList>;

export type StackNavigationProps = {
  navigation: StackNavigation;
};

const Stack = createStackNavigator<StackParamList>();

export function StackRoutes() {
  return (
    <Stack.Navigator
      initialRouteName="SignIn"
      screenOptions={{ headerShown: false }}
    >
      <Stack.Screen name="SignIn" component={SignIn} />
      <Stack.Screen name="SignUp" component={SignUp} />
      <Stack.Screen name="Drawer" component={DrawerRoutes} />
    </Stack.Navigator>
  );
}
