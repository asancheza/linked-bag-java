/*
 * (C) Copyright 2016 Alejandro Sanchez Acosta.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:
 *     Alejandro Sanchez Acosta <asanchez@neurowork.net>
 */

/* 
 * Bag Interface
 */
public interface GenericBag <T> {
	void add(T value);
	void remove(T value);
	boolean isEqual(GenericBag<T> other);
	int getElementCount();

	boolean contains(T value);
	int count(T value);
}